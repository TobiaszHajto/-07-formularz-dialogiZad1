Lambda działa tylko z interfejsami, które mają jedną metodę.
CheckBox ma tylko jedno zadanie (zmianę stanu), więc lambda bez problemu wystarczy. 
SeekBar reaguje aż na trzy różne sytuacje (dotknięcie, przesuwanie, puszczenie), przez co komputer nie wiedziałby, którą z nich ma obsłużyć sama lambda.
Dlatego przy suwaku trzeba użyć tradycyjnej klasy anonimowej i rozpisać wszystkie trzy metody.
