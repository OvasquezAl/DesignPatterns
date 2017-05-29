/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct tcola {
  int torrea[3];
  int torreb[3];
  int torrec[3];
  int na;
  int nb;
  int nc;
  int todos[280];
  struct tcola *sig;
};

int max = 0;

int obtenera(struct tcola **c1) { return (*c1)->sig->na; }
int obtenerb(struct tcola **c1) { return (*c1)->sig->nb; }
int obtenerc(struct tcola **c1) { return (*c1)->sig->nc; }

int nivel(struct tcola **c1, int p) {
  if (p == 0)
    return (*c1)->sig->na;
  if (p == 1)
    return (*c1)->sig->nb;
  if (p == 2)
    return (*c1)->sig->nc;
  return (*c1)->sig->nc;
}

int *obtenerta(struct tcola **c1) { return (*c1)->sig->torrea; }
int *obtenertb(struct tcola **c1) { return (*c1)->sig->torreb; }
int *obtenertc(struct tcola **c1) { return (*c1)->sig->torrec; }

int * datostorre(struct tcola **c1, int t) {
  if (t == 0)
    return (*c1)->sig->torrea;
  if (t == 1)
    return (*c1)->sig->torreb;
  if (t == 2)
    return (*c1)->sig->torrec;
  return (*c1)->sig->torrec;
}

int *obteneranteriores(struct tcola **c1) { return (*c1)->sig->todos; }

void agregar(struct tcola **cola, int da[], int db[], int dc[], int a, int b,
             int c, int en[]) {
  struct tcola *nuevo;

  nuevo = (struct tcola *)malloc(sizeof(struct tcola));

  nuevo->na = a;
  nuevo->nb = b;
  nuevo->nc = c;

  for (int i = 0; i < 3; i++) {
    nuevo->torrea[i] = da[i];
  }
  for (int i = 0; i < 3; i++) {
    nuevo->torreb[i] = db[i];
  }
  for (int i = 0; i < 3; i++) {
    nuevo->torrec[i] = dc[i];
  }

  for (int i = 0; i < 280; i++) {
    nuevo->todos[i] = 40;
  }

  int in = 0;
  for (int i = 0; en[i] < 20; i++) {
    nuevo->todos[i] = en[i];
    in++;
  }

  for (int i = 0; i < 3; i++) {
    nuevo->todos[in++] = da[i];
  }
  nuevo->todos[in++] = a;
  for (int i = 0; i < 3; i++) {
    nuevo->todos[in++] = db[i];
  }
  nuevo->todos[in++] = b;
  for (int i = 0; i < 3; i++) {
    nuevo->todos[in++] = dc[i];
  }
  nuevo->todos[in++] = c;
  nuevo->todos[in++] = 20;

  if (*cola == NULL)
    nuevo->sig = nuevo;
  else {
    nuevo->sig = (*cola)->sig;
    (*cola)->sig = nuevo;
  }
  (*cola) = nuevo;
  max++;
}

void eliminar(struct tcola **c1) {
  int elem = 0;
  struct tcola *aux;
  if ((*c1) == (*c1)->sig) {
    free(*c1);
    *c1 = NULL;
  } else {
    aux = (*c1)->sig;
    (*c1)->sig = aux->sig;
    free(aux);
  }
  max--;
}
