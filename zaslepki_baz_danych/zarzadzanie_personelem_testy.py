import requests

#TEST dodaj_pracownika
r1 = requests.post("http://127.0.0.1:5000/dodaj_pracownika", data={'id_restauracji': 1, 'imie': "Janko",
                                                                   'nazwisko': "Muzykant", 'telefon': "14141918",
                                                                   'stanowisko': "Szef", 'login': "szefcio15",
                                                                   'haslo': "24389f0wy8"})
print(r1.text)


if r1.text == 'Dodano pracownika o loginie szefcio15, oraz imieniu i nazwisku Janko Muzykant do resturacji 1':
    print("SUCCESS!")
else:
    print("FAILURE!")