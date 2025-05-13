import 'dart:convert'

class Document {
  final String id;
  final String title;
  final String uid;
  final List content;
  final DateTime createdAt;
  Document({
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

  factory Document.fromMap(Map<String, dynamic> map) {
    return Document(
      id: map['_id'] ?? '',
      title: map['title'] ?? '',
      uid: map['uid'] ?? '',
      content: List.from(map['content']),
      createdAt: DateTime.fromMillisecondsSinceEpoch(map['createdAt']), 
    );
  }

  String toJson() => json.encode(toMap());

  factory Document.fromJson(String source) => Document.fromMap(json.decode(source));
}
