#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# biblioteka pandas posłuży nam do wczytania zbioru danych do obiektu DataFrame
import pandas as pd 

import matplotlib.pyplot as plt
import numpy as np

# SPRAWDZ SCIEZKE
df = pd.read_csv('.\irisdatawn.sec', header=None)
# wyświetlimy informacje o liczbie wczytanych wierszy
print('liczba rekordów we wczytamym pliku wynosi:',len(df))

# sprawdźmy jakie mamy wogóle kategorie
Z = df.iloc[0:150, 4].values
print('liczba etykiet we wczytamym zbiorze wynosi:', np.unique(Z))

#a teraz informacje statystyczne (opisowe) danych
print(df.describe())


# wyświetlimy dane które wczytaliśmy, ale 4 ostatnie wiersze
print(df.tail(4))

# tu sobie narysujemy wykres z cześci danych
# wybiera gatunki setosa i versicolor
y = df.iloc[0:100, 4].values
y = np.where(y == 'Iris-setosa', -1, 1)

# wydobywa cechy: długość działki i długość płatka
X = df.iloc[0:100, [0, 2]].values

# rysuje wykres
plt.scatter(X[:50, 0], X[:50, 1],
            color='red', marker='o', label='setosa')
plt.scatter(X[50:100, 0], X[50:100, 1],
            color='blue', marker='x', label='versicolor')

plt.xlabel('Długość działki [cm]')
plt.ylabel('Długość płatka [cm]')
plt.legend(loc='upper left')

# rysuje wykres
plt.show()


# Sprawdźmy czy wystepują jakieś brakujące dane - tu jes wyświetlimy
print('Tyle wierszy ma null: ', df.isnull().sum().sum())

print(df.head())

# a teraz wyswietlimy te wiersze z NaN
selected_rows = df[df[0].isnull() | df[1].isnull() | df[2].isnull() | df[3].isnull()]
print(selected_rows)


#lub alternatywnie ich szukamy i wyświetlimy
print('a teraz pokażmy jak alternatywnie mozemy ich wyszukać')
nan_rows = df.loc[df.isna().any(axis=1)]
# i też ich wyswietlenie
print(nan_rows)


# brakujące dane wypełnimy średnią
# a teraz w petli przechodzimy kolejne kolumny w danych; liczymy średnie po kolumnach i tymi średnimi wypełniamy NaN
for i in range(len(df.columns)-1):
    missing_col = [i]
    for j in missing_col:
        df.loc[df.loc[:, i].isnull(), j] = df.loc[:, j].mean()


# Sprawdźmy czy wystepują jakieś brakujące dane NaN - tu jes wyświetlimy
print('NaN występuje teraz: ', df.isnull().sum().sum(), ' razy')
# i wyswietlamy te wiersze
if df.isnull().sum().sum() > 0:
    selected_rows = df[df[0].isnull() | df[1].isnull() | df[2].isnull() | df[3].isnull()]
    print(selected_rows)



# standaryzacja - ale poniżej zrobiono to tylko dla 1 kolumny o indeksie 0
for i in range(len(df.columns)-1):
    df[i] = (df[i] - df[i].mean()) / df[i].std()


# wyświetlimy dane które zostały poddane standaryzacji
print(df)


#zapis do pliku - ALE SPRAWDZ SCIEZKE
df.to_csv('.\iris.data.output')