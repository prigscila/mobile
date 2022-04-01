import 'dart:math';

import 'package:SorteioApp/alerta.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class SorteadorPage extends StatefulWidget {
  @override
  _SorteadorPageState createState() => _SorteadorPageState();
}

class _SorteadorPageState extends State<SorteadorPage> {
  int _inicial = 1;
  int _final = 100;
  int _sorteado;

  bool _ehValidoParaSorteio() {
    return _final > _inicial;
  }

  void _sortear() {
    if (!_ehValidoParaSorteio()) {
      showDialog(context: context, child: new Alerta());
      return;
    }

    setState(() {
      var random = new Random();
      _sorteado = _inicial + random.nextInt(_final - _inicial);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Sorteador'),
      ),
      body: Container(
        margin: EdgeInsets.only(top: 20),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          children: <Widget>[
            Text(
              'Entre com o intervalo',
              style: Theme.of(context).textTheme.headline5,
            ),
            SizedBox(
              child: Container(
                padding: EdgeInsets.all(20),
                child: Row(
                  children: <Widget>[
                    Flexible(
                      child: TextFormField(
                        cursorColor: Theme.of(context).cursorColor,
                        keyboardType: TextInputType.number,
                        textAlign: TextAlign.center,
                        inputFormatters: <TextInputFormatter>[
                          FilteringTextInputFormatter.digitsOnly,
                        ],
                        onChanged: (value) {
                          setState(() {
                            _inicial = int.parse(value);
                          });
                        },
                        initialValue: _inicial.toString(),
                        key: Key('InicialInput'),
                      ),
                    ),
                    SizedBox(
                      width: 20,
                    ),
                    Flexible(
                      child: TextFormField(
                        cursorColor: Theme.of(context).cursorColor,
                        keyboardType: TextInputType.number,
                        inputFormatters: <TextInputFormatter>[
                          FilteringTextInputFormatter.digitsOnly,
                        ],
                        textAlign: TextAlign.center,
                        onChanged: (value) {
                          setState(() {
                            _final = int.parse(value);
                          });
                        },
                        initialValue: _final.toString(),
                        key: Key('FinalInput'),
                      ),
                    )
                  ],
                ),
              ),
            ),
            ElevatedButton(
              onPressed: _sortear,
              child: Text('Sortear'),
              key: Key('SorteioButton'),
            ),
            Text(
              _sorteado != null ? '$_sorteado' : 'Nenhum valor sorteado',
              style: Theme.of(context).textTheme.headline4,
              key: Key('Sorteado'),
            ),
          ],
        ),
      ),
    );
  }
}
