from corr import C

class Coeficientes:
    def coeficienteNumeros(self, n1, n2, n3):
        coeficiente = 0
        if (n3 >= n1):
            coeficiente = n2 / n3
            if (n2 % n3 == 0):
                print(int(coeficiente))
                Coeficientes.cocientesNumero( self, n1, n2, n3 - 1 )
            else:
                Coeficientes.cocientesNumero( self, n1, n2, n3 - 1 )
        elif (n3 <= 1):
            print( int( n2 ) )


r = Coeficientes()
print( "Ingresa el primer numero: ")
n2= C.correccion()
print( "Ingresa el segundo numero: ")
n1 = C.correccion(C)
print( "Los cocientes son:" )
r.cocientes( n1, n2, n2 )
