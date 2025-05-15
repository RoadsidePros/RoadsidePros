import 'package:flutter/material.dart';

class RequestHistoryScreen extends StatelessWidget {
  const RequestHistoryScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final List<Map<String, String>> history = [
      {'date': '2025-05-01', 'type': 'Flat Tire'},
      {'date': '2025-05-06', 'type': 'Battery Jump'},
    ];

    return Scaffold(
      appBar: AppBar(title: const Text('Request History')),
      body: ListView.builder(
        itemCount: history.length,
        itemBuilder: (context, index) {
          final item = history[index];
          return ListTile(
            title: Text(item['type']!),
            subtitle: Text(item['date']!),
          );
        },
      ),
    );
  }
}