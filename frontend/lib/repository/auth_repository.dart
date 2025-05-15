import 'dart:convert';

import 'package:frontend/models/user.dart';

import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:http/http.dart';

final authRepositoryProvider = Provider((ref) => AuthRepository(googleSignIn: GoogleSignIn(), client: Client()));

class AuthRepository {
  final GoogleSignIn _googleSignIn;
  final Client _client;
  AuthRepository({ required GoogleSignIn googleSignIn, required Client client }) 
    : _googleSignIn = googleSignIn,
      _client = client;


  void signInWithGoogle() async {
    try {
      final user = await _googleSignIn.signIn();
      if (user != null) {
        final userAccount = User(
          id: user.id,
          name: user.name,
          email: user.email,
          profilePicture: user.profilePicture,
          uid: '',
          token: '',
        );

        var response = _client.post(Uri.parse('$BACKEND_URL/api/v1/signup/', id), body: userAccount.toJson(), headers: {
          'Content-Type': 'application/json; charset=UTF-8',
        });

        switch (response.statusCode) {
          case 200:
            final newUser = userAccount.copyWith(
              uid: jsonDecode(response.body)['user']['_id'],
            );
            break;
        }
      }
    } catch (e) {
      print(e);
    }

  }
}
