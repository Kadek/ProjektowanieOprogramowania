from flask import Flask, request, render_template, jsonify

app = Flask(__name__)


@app.route('/')
def main_site():
    return render_template('test.html')


@app.route('/pobierz_menu_restauracji', methods=['GET'])
def pobierz_menu_restauracji():
    network_menu = [[1, "Ciastko", 29.99, "Pycha ciacho"],
                    [2, "Kawa", 5.99, "Dobra kawusia"]]
    restaurant_menu = [[1, "Ciastko", 29.99, "Pycha ciacho"],
                       [2, "Kawa", 5.99, "Dobra kawusia"],
                       [3, "Bułka", 2.99, "Duża buła"]]

    if request.args.get("id_restauracji") is None:
        return "ERROR. Nie moge dostac sie do id restauracji"
    id_restauracji = int(request.args.get("id_restauracji"))
    if id_restauracji == 0:
        return jsonify(network_menu)
    else:
        return jsonify(restaurant_menu)


@app.route('/dodaj_danie', methods=['POST'])
def dodaj_danie():
    if request.form['id_restauracji'] is None:
        return "ERROR. Nie moge dostac sie do id restauracji"
    id_restauracji = int(request.form['id_restauracji'])

    if request.form['id_dania'] is None:
        return "ERROR. Nie moge dostac sie do id dania"
    id_dania = int(request.form['id_dania'])

    if request.form['nazwa'] is None:
        return "ERROR. Nie moge dostac sie do nazwy"
    nazwa = str(request.form['nazwa'])

    if request.form['cena'] is None:
        return "ERROR. Nie moge dostac sie do ceny"
    cena = float(request.form['cena'])

    if request.form['opis'] is None:
        return "ERROR. Nie moge dostac sie do opisu"
    opis = str(request.form['opis'])

    return "Dodano danie o id=" + str(id_dania) + ", nazwie= " \
           + nazwa + ", cenie=" + str(cena) + ", opisie=" + opis + " do restauracji " + str(id_restauracji)


@app.route('/modyfikuj_danie', methods=['POST'])
def modyfikuj_danie():
    if request.form['id_restauracji'] is None:
        return "ERROR. Nie moge dostac sie do id restauracji"
    id_restauracji = int(request.form['id_restauracji'])

    if request.form['id_dania'] is None:
        return "ERROR. Nie moge dostac sie do id dania"
    id_dania = int(request.form['id_dania'])

    if request.form['nazwa'] is None:
        return "ERROR. Nie moge dostac sie do nazwy"
    nazwa = str(request.form['nazwa'])

    if request.form['cena'] is None:
        return "ERROR. Nie moge dostac sie do ceny"
    cena = float(request.form['cena'])

    if request.form['opis'] is None:
        return "ERROR. Nie moge dostac sie do opisu"
    opis = str(request.form['opis'])

    return "Zmodyfikowano danie o id=" + str(id_dania) + ", nazwie= " \
           + nazwa + ", cenie=" + str(cena) + ", opisie=" + opis + " do restauracji " + str(id_restauracji)


@app.route('/usun_danie', methods=['POST'])
def usun_danie():
    if request.form['id_dania'] is None:
        return "ERROR. Nie moge dostac sie do id dania"
    id_dania = int(request.form['id_dania'])
    return "Usunieto danie o id=" + str(id_dania)


if __name__ == '__main__':
    app.run()
