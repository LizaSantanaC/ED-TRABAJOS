class Vertice:

    def __init__(self, x):
        if (x == None):
            pass
        self.nombre = x
        self.numVertice = -1

    def nomVertice(self):
        return self.nombre

    def equals(self, n):
        return self.nombre == n.nombre

    def asigVert(self, n):
        self.numVertice = n

    def __str__(self):
        return self.nombre + "(" + str( self.numVertice ) + ")"


class GrafoMatriz:

    def __init__(self, mx):
        if (mx == None):
            self.maxVerts
        self.maxVerts = mx
        self.matAd = [[]]
        for i in range( mx ):
            self.matAd.append( [] )
            for j in range( mx ):
                self.matAd[i].append( None )
        self.verts = []
        for i in range( mx ):
            self.verts.append( Vertice( None ) )
            j = 0
            while (i < mx):
                self.matAd[i][j] = 0;
                i += 1
        self.numVerts = 0

    def nuevoVertice(self, nom):
        esta = (self.numVertice( nom ) >= 0)
        if (not esta):
            v = Vertice( nom )
            v.asigVert( self.numVerts )
            self.verts[self.numVerts] = v
            self.numVerts = self.numVerts + 1

    def numVertice(self, vs):
        v = Vertice( vs );
        encontrado = 0
        i = 0
        while (i < self.numVerts and encontrado == 0):

            if (self.verts[i].equals( v )):
                encontrado = 1
            if (encontrado == 0):
                i += 1
        if (i < self.numVerts):
            return i
        else:
            return -1

    def nuevoArco(self, a, b):
        va = self.numVertice( a )
        vb = self.numVertice( b )
        try:
            if (va < 0 or vb < 0):
                print( "El vertice no existe" )
        finally:
            pass
        self.matAd[va][vb] = 1

    def adyacente(self, a, b):
        va = self.numVertice( a )
        vb = self.numVertice( b )
        try:
            if (va < 0 or vb < 0):
                print( "El vertice no existe" )
        finally:
            pass
        return (self.matAd[va][vb] == 1)

    def recorrerAnchura(self, g, org):
        w = None
        v = g.numVertice( org )

        CLAVE = -1

        if (v < 0):
            print( "El vetice origen no existe" )

        cola = ColaLista()
        m = []
        for i in range( g.numVerts ):
            m.append( CLAVE )
        m[v] = 0
        cola.insertar( v )
        while (not cola.colaVacia()):
            cw = cola.quitar()
            w = cw
            print( f'Vertice {g.verts[w]} visitado' )
            for u in range( g.numVerts ):
                try:
                    if (g.matAd[w][u] == 1 and m[u] == CLAVE):
                        m[u] = m[w] + 1
                        cola.insertar( u )
                except:
                    print( "El vertice no existe" )
        return m


class Nodo:

    def __init__(self, x, n, y):
        if (x == None):
            self.dato = int()
        else:
            self.dato = x
        if (n == None):
            self.siguiente = None
        else:
            self.siguiente = n
        if (y == None):
            self.elemento = None
        else:
            self.elemento = y

    def getDato(self):
        return self.dato

    def getEnlace(self):
        return self.siguiente

    def setEnlace(self, enlace):
        self.siguiente = enlace


class ColaLista:

    def __init__(self):
        self.frente = None
        self.fin = None

    def insertar(self, e):
        elemento = Nodo( None, None, e )
        if (self.colaVacia()):
            self.frente = elemento
        else:
            self.fin.setEnlace( elemento )
        self._fin = elemento

    def quitar(self):
        aux = None
        if (not self.colaVacia()):
            aux = self.frente.elemento
            self.frente = self.frente.siguiente
        else:
            print( "Eliminar de una cola vacia" )
        return aux

    def borrarCola(self):
        while (self._frente != None):
            self._frente = self._frente.siguiente

    def frenteCola(self):
        if (self.colaVacia()):
            print( "la cola esta vacia" )
            return None
        else:
            return self._frente.elemento

    def colaVacia(self):
        return (self.frente == None)


class Arco:

    def __init__(self, d, p):
        self.destino = d
        if (p == None):
            self.peso = 0.0
        else:
            self.peso = p

    def getDestino(self):
        return self.destino

    def equals(self, n):
        a = n
        return (self.destino == a.destino)


numV = int( input( "Ingresa el numero maximo de vertices" ) )
gm = GrafoMatriz( numV )

while (True):

    print( "1. Agregar vertice" );
    print( "2. Agregar arco" );
    print( "3. Saber si son adyacentes" );
    print( "4. Recorrer" );
    print( "5. Salir" );

    op = int( input( "Escribe una de las opciones" ) )

    if (op == 1):
        gm.nuevoVertice( str( input( "Ingresa el vertice:" ) ) )
    elif (op == 2):
        a = input( "Ingresa el origen: " )
        b = input( "Ingresa el destino: " )
        try:
            gm.nuevoArco( a, b )
        except:
            print( "Debes ingresar vertices correctos" )
    elif (op == 3):
        a = input( "Ingresa verice origen a buscar: " )
        b = input( "Ingresa el vertice destino:" )
        try:
            if (gm.adyacente( a, b )):
                print( "Son adyacentes" )
            else:
                print( "No son adyacentes" )
        except:
            print( "Debes ingresar vertices correctos" )
    elif (op == 4):
        origen = input( "Ingresa el vertice origen a recorrer:" )
        try:
            gm.recorrerAnchura( gm, origen )
            print()
        except:
            print( "Debes ingresar vertices correctos" )
    elif (op == 5):
        break
    else:
        print( "Debes ingresar numeros entre 1 y 5 " )
