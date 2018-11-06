import requests

#TEST dodaj_zamowienie
r1 = requests.post("http://127.0.0.1:5000/dodaj_zamowienie", data={'id_klienta': 2,'id_restauracji': 1,
                                                                   'lista_dan': ['1, Chleb, 2, Kawa'], 'kwota': 29.99})
print(r1.text)


if r1.text == '44':
    print("SUCCESS!")
else:
    print("FAILURE!")