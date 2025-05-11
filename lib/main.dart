import 'package:flutter/material.dart';
import 'screens/login_screen.dart';

void main() {
  runApp(const RoadsideProsApp());
}

class RoadsideProsApp extends StatelessWidget {
  const RoadsideProsApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Roadside Pros',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const LoginScreen(),
      debugShowCheckedModeBanner: false,
    );
  }
}