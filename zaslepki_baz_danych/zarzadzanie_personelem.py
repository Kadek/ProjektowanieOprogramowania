from flask import Flask, request, render_template, jsonify

app = Flask(__name__)


@app.route('/')
def main_site():
    return render_template('test.html')


@app.route('/dodaj_pracownika', methods=['POST'])
def dodaj_pracownika():
    if request.form['id_restauracji'] is None:
        return "ERROR. Nie moge dostac sie do id restuaracji"
    id_restauracji = int(request.form['id_restauracji'])

    if request.form['imie'] is None:
        return "ERROR. Nie moge dostac sie do imienia"
    imie = str(request.form['imie'])

    if request.form['nazwisko'] is None:
        return "ERROR. Nie moge dostac sie do nazwiska"
    nazwisko = str(request.form['nazwisko'])

    if request.form['telefon'] is None:
        return "ERROR. Nie moge dostac sie do telefonu"
    telefon = str(request.form['telefon'])

    if request.form['stanowisko'] is None:
        return "ERROR. Nie moge dostac sie do stanowiska"
    stanowisko = str(request.form['stanowisko'])

    if request.form['login'] is None:
        return "ERROR. Nie moge dostac sie do loginu"
    login = str(request.form['login'])

    if request.form['haslo'] is None:
        return "ERROR. Nie moge dostac sie do hasla"
    haslo = str(request.form['haslo'])



    return "Dodano pracownika o loginie " + login + ", oraz imieniu i nazwisku " + imie + " " \
           + nazwisko + " do resturacji " + str(id_restauracji)



@app.route('/usun_pracownika', methods=['POST'])
def usun_pracownika():
    if request.form['id_pracownika'] is None:
        return "ERROR. Nie moge dostac sie do id pracownika"
    id_pracownika = int(request.form['id_pracownika'])
    return "Usunieto pracownika o id " + str(id_pracownika)


@app.route('/pobierz_pracownikow', methods=['GET'])
def pobierz_pracownikow():
    lista_pracownikow = [[1, "Jan", "Kek", "123456789", "Kucharz", "JanKe"],
                         [2, "Piotr", "Ptak", "123456789", "Menadzer", "Duzy_Ptak12"],
                         [3, "Adrian", "Hasz", "123456789", "Kucharz", "haszImasz"]]

    if request.args.get("id_restauracji") is None:
        return "ERROR. Nie moge dostac sie do id restauracji"
    id_restauracji = int(request.args.get("id_restauracji"))


    return jsonify(lista_pracownikow)


if __name__ == '__main__':
    app.run()
