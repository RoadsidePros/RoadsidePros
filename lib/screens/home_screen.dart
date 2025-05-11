import 'package:flutter/material.dart';
import 'request_service_screen.dart';
import 'request_history_screen.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Roadside Pros')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              child: const Text('Request Service'),
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (_) => const RequestServiceScreen()),
                );
              },
            ),
            const SizedBox(height: 16),
            ElevatedButton(
              child: const Text('View Request History'),
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (_) => const RequestHistoryScreen()),
                );
              },
            ),
          ],
        ),
      ),
    );
  }
}