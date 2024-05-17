import requests

url = "https://api.artic.edu/api/v1/artworks/27992?fields=id,title,image_id"

art_json = []

art_json.append(requests.get(url).json())

print(art_json)