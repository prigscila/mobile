import 'package:flutter/material.dart';

class Alerta extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return SimpleDialog(title: Text('Ooops!'), children: [
      Padding(
        padding: const EdgeInsetsDirectional.only(start: 23.0),
        child: Text('Não foi possível fazer o sorteio :('),
      ),
      Padding(
        padding: const EdgeInsetsDirectional.only(start: 23.0),
        child: Text('Valide se os valores informados estão corretos.'),
      ),
    ]);
  }
}
