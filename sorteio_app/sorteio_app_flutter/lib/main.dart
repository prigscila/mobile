import 'package:SorteioApp/sorteador.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(SorteioApp());
}

class SorteioApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Sorteador',
      theme: ThemeData(
        primarySwatch: Colors.purple,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: SorteadorPage(),
    );
  }
}
