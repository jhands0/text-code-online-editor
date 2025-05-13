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
}
