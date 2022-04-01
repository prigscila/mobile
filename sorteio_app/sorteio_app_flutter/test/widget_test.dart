import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

import 'package:SorteioApp/main.dart';

void main() {
  testWidgets('Should load elements', (WidgetTester tester) async {
    await tester.pumpWidget(SorteioApp());

    expect(find.byKey(Key('InicialInput')), findsOneWidget);
    expect(find.byKey(Key('FinalInput')), findsOneWidget);
    expect(find.byKey(Key('SorteioButton')), findsOneWidget);
    expect(find.text('Nenhum valor sorteado'), findsOneWidget);
  });

  testWidgets('Should draw a number within range', (WidgetTester tester) async {
    await tester.pumpWidget(SorteioApp());

    await tester.tap(find.byKey(Key('SorteioButton')));
    await tester.pump();

    final sorteado = tester.widget<Text>(find.byKey(Key('Sorteado')));
    int valorSorteado = int.parse(sorteado.data);

    expect(valorSorteado, inInclusiveRange(1, 100));
    expect(find.text('Nenhum valor sorteado'), findsNothing);
  });
}
