import 'dart:convert'

class DocumentModel {
  final String id;
  final String title;
  final String uid;
  final List content;
  final DateTime createdAt;
  DocumentModel({
    required this.id,
    required this.title,
    required this.uid,
    required this.content,
    required this.createdAt,
  });

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'title': title,
      'uid': uid,
      'content': content,
      'createdAt': createdAt,
    };
  }

  factory DocumentModel.fromMap(Map<String, dynamic> map) {
    return DocumentModel(
      id: map['_id'] ?? '',
      title: map['title'] ?? '',
      uid: map['uid'] ?? '',
      content: List.from(map['content']),
      createdAt: DateTime.fromMillisecondsSinceEpoch(map['createdAt']), 
    );
  }

  String toJson() => json.encode(toMap());

  factory DocumentModel.fromJson(String source) => DocumentModel.fromMap(json.decode(source));
}
