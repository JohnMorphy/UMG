import pandas as pd

df = pd.read_csv('stragan0.csv')

df.columns = df.columns.str.strip()

grouped = df.groupby('Transakcja')['kupione_artykuly'].apply(lambda x: ','.join(x)).reset_index()

print(grouped)

grouped.to_csv('formatted_stragan0.csv', index=False, header=False)