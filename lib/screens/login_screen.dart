import 'package:flutter/material.dart';
import 'home_screen.dart';

class LoginScreen extends StatelessWidget {
  const LoginScreen({super.key});

  void _login(BuildContext context) {
    Navigator.pushReplacement(
      context,
      MaterialPageRoute(builder: (context) => const HomeScreen()),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Login')),
      body: Center(
        child: ElevatedButton(
          onPressed: () => _login(context),
          child: const Text('Login'),
        ),
      ),
    );
  }
}