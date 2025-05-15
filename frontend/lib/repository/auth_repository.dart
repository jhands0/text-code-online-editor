import 'package:frontend/models/user.dart';

import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:google_sign_in/google_sign_in.dart';

final authRepositoryProvider = Provider((ref) => AuthRepository(googleSignIn: GoogleSignIn()));

class AuthRepository {
  final GoogleSignIn _googleSignIn;
  AuthRepository({
    required GoogleSignIn googleSignIn,
  }) : _googleSignIn = googleSignIn;

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
      }
    } catch (e) {
      print(e);
    }

  }
}
