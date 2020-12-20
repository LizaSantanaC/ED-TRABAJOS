class CadenaInversa:
    def inversa(self, n, cadena):
        if (n >= 0):
            print( cadena[n], end="" )
            CadenaInversa.inversa( self, n - 1, cadena )
        print()


print( "Ingresa una cadena:" )
cadena1 = input()
cadena2 = CadenaInversa()
print("Cadena inversa: ")
cadena2.inversa( len(cadena1) - 1, cadena1)