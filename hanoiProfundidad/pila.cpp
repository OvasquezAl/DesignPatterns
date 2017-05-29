/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include <stdlib.h>

int nada[] = {-1};

typedef struct _tnodo {
  int torrea[8];
  int torreb[8];
  int torrec[8];
  int na;
  int nb;
  int nc;
  struct _tnodo *siguiente;
} tipoNodot;

typedef tipoNodot *pNodot;
typedef tipoNodot *Pilat;

void Push(Pilat *pilat, int da[], int db[], int dc[], int a, int b, int c) {
  pNodot nuevo;
  nuevo = (pNodot)malloc(sizeof(tipoNodot));

  for (int i = 0; i < 8; i++) {
    nuevo->torrea[i] = da[i];
    nuevo->torreb[i] = db[i];
    nuevo->torrec[i] = dc[i];
  }

  nuevo->na = a;
  nuevo->nb = b;
  nuevo->nc = c;

  nuevo->siguiente = *pilat;
  *pilat = nuevo;
}

int nivelpila(Pilat *pilat, int p) {
  pNodot nodo;
  nodo = *pilat;
  if (!nodo)
    return -1;

  if (p == 0)
    return nodo->na;
  if (p == 1)
    return nodo->nb;
  if (p == 2)
    return nodo->nc;

  return -1;
}

int *datostorre(Pilat *pilat, int t) {
  pNodot nodo;
  nodo = *pilat;

  if (t == 0)
    return nodo->torrea;
  if (t == 1)
    return nodo->torreb;
  if (t == 2)
    return nodo->torrec;

  return nada;
}

int Pop(Pilat *pilat) {
  pNodot nodo;
  int v;
  nodo = *pilat;
  if (!nodo)
    return -1;
  *pilat = nodo->siguiente;
  v = nodo->nc;
  free(nodo);
  return v;
}
