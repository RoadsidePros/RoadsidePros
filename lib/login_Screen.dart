import 'package:flutter/material.dart';
import 'auth_service.dart';

class LoginScreen extends StatelessWidget {
  final AuthService _authService = AuthService();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      body: Center(
        child: ElevatedButton.icon(
          onPressed: () async {
            final user = await _authService.signInWithGoogle();
            if (user != null) {
              // Navigate to the home screen
              Navigator.pushReplacementNamed(context, '/home');
            }
          },
          icon: Icon(Icons.login),
          label: Text('Sign in with Google'),
          style: ElevatedButton.styleFrom(
            backgroundColor: Colors.yellow[700],
            foregroundColor: Colors.black,
          ),
        ),
      ),
    );
  }
}