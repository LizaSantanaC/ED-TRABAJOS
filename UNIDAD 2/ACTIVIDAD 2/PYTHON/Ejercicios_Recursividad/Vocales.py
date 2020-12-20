class Vocales:
    def contarVocal(self, cadena, n, x):
        existe = True
        caracter = ' '
        try:
            caracter = cadena[n]
            existe = True
        except IndexError:
            existe = False
        if (existe == True):
            if (caracter == 'a' or caracter == 'e' or caracter == 'i' or caracter == 'o' or caracter == 'u'):
                x = x + 1
                Vocales.contarVocal( self, cadena, n + 1, x )
                return x
            else:
                Vocales.contarVocal( self, cadena, n + 1, x )
        else:
            print("La cadena: " + cadena + " contiene", x, "vocales")
            return x
        return x
        pass

vocal= Vocales()
print("Ingresa una cadena: ")
cad = input().lower()
vocal.contarVocal(cad, 0, 0)
