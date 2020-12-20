class PruebaPilaEstatica:
    def validacion(self):
        while True:
            try:
                r = int( input() )
            except:
                print( "Solo nùmero: " )
            else:
                if r > 0:
                    break
                else:
                    print( "El nùmero debe ser positivo" )
        return r

    def validacionC(self):
        while True:
            try:
                r = int( input() )
            except:
                print( "Solo nùmero:" )
            else:
                if r > 4:
                    break
                else:
                    print( "Debe ser mayor a 5" )
        return r


class PilaPelicula:
    def __init__(self, titulo, genero):
        if titulo is None:
            self.__titulo = str( "" )
        else:
            self.__titulo = titulo

        if genero is None:
            self.__genero = str( "" )
        else:
            self.__genero = genero

    def getTitulo(self):
        return self.__titulo

    def setTitulo(self, titulo):
        self.__titulo = titulo

    def getGenero(self):
        return self.__genero

    def setGenero(self, genero):
        self.__genero = genero

    def __str__(self):
        return ("Titulo pelicula: " + self.getTitulo() + ", Genero pelicula: " + self.getGenero() + "]")


class RentaPeliculas:
    def crear(self):
        return []

    def apilar(self, pila, pelicula):
        pila.append( pelicula )
        return pila

    def vacia(self, pila):
        return (len( pila ) == 0)

    def desapilar(self, pila):
        if (self.vacia( RentaPeliculas, pila )):
            print( "Pila vacia" )
        else:
            pila.pop()
        return pila

    def cima(self, pila):
        if (self.vacia( RentaPeliculas, pila )):
            print( "Pila vacia" )
            return -1
        else:
            return pila[-1]

    def rentar(self, pila):
        print( "----------RENTA---------" )
        if (self.vacia( RentaPeliculas, pila )):
            print( "Fallò la renta" )
            return None
        else:
            return self.cima( RentaPeliculas, pila )

    def devolver(self, pila, pelicula):
        print( "----------ENTREGA PELICULA----------" )
        self.apilar( RentaPeliculas, pila, pelicula )
        return pila


class ImplementacionPilaEstatica:
    def __init__(self, n):
        self.peliculas = ([None] * int( n ))
        self.puntero = -1

    def llena(self):
        return (self.puntero == (len( self.peliculas ) - 1))

    def vacia(self):
        return (self.puntero == (-1))

    def rentar(self):
        if (self.vacia()):
            print( "Pila vacia" )
            return None
        else:
            peliculastmp = ([None] * (self.puntero + 1))
            for i in range( len( peliculastmp ) ):
                peliculastmp[i] = self.peliculas[i]
            ret = RentaPeliculas.rentar( RentaPeliculas, peliculastmp )
            peliculasret = RentaPeliculas.desapilar( RentaPeliculas, peliculastmp )
            for i in range( len( peliculasret ) ):
                self.peliculas[i] = peliculasret[i]
            self.peliculas[self.puntero] = None
            self.puntero -= 1
            return ret

    def devolver(self, pelicula):
        if (self.llena()):
            print( "Pila llena" )
        else:
            peliculastmp = ([None] * (self.puntero + 1))
            for i in range( len( peliculastmp ) ):
                peliculastmp[i] = self.peliculas[i]
            peliculasret = RentaPeliculas.devolver( RentaPeliculas, peliculastmp, pelicula )
            for i in range( len( peliculasret ) ):
                self.peliculas[i] = peliculasret[i]
            self.puntero += 1

    def cantidad(self):
        print( "Peliculas disponibles: " + str( self.puntero + 1))

    def mostrar(self):
        for i in self.peliculas:
            print( i )


rentada = PilaPelicula( None, None )
ipe = ImplementacionPilaEstatica( 5 )

while True:
    print( "1. Cargar BD de peliculas" )
    print( "2. Rentar pelicula" )
    print( "3. Regresar pelicula" )
    print( "4. Catalogo de peliculas" )
    print( "5. Salir" )
    opcion = PruebaPilaEstatica.validacion( PruebaPilaEstatica )
    if (opcion == 1):
        print( "Cantidad minima renta ----> 5: " )
        n = PruebaPilaEstatica.validacionC( PruebaPilaEstatica )
        ipe = ImplementacionPilaEstatica( n )
        for i in range( n ):
            print( "Pelicula " + str( i + 1 ) + ":" )
            titulo = str( input( "Titulo pelicula: " ) )
            genero = str( input( "Genero pelicula: " ) )
            pelicula = PilaPelicula( titulo, genero )
            ipe.devolver( pelicula )
    elif (opcion == 2):
        rentada = ipe.rentar()
        print( rentada )
    elif (opcion == 3):
        ipe.devolver( rentada )
    elif (opcion == 4):
        ipe.cantidad()
        ipe.mostrar()
    elif (opcion == 5):
        print( "------------------------------------")
        break
    else:
        print( "OPcion invalida" )
