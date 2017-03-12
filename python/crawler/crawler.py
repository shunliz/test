# -*- coding:UTF-8 -*-

import requests
from bs4 import BeautifulSoup
import os
import traceback
import pdb

def download(url, filename):
    if os.path.exists(filename):
        print('file exists!')
        return
    try:
        r = requests.get(url, stream=True, timeout=60)
        r.raise_for_status()
        with open(filename, 'wb') as f:
            for chunk in r.iter_content(chunk_size=1024):
                if chunk:  # filter out keep-alive new chunks
                    f.write(chunk)
                    f.flush()
        return filename
    except KeyboardInterrupt:
        if os.path.exists(filename):
            os.remove(filename)
        raise KeyboardInterrupt
    except Exception:
        traceback.print_exc()
        if os.path.exists(filename):
            os.remove(filename)


if os.path.exists('imgs') is False:
    os.makedirs('imgs')

start = 1
end = 8000
for i in range(start, end + 1):
    #url = 'http://konachan.net/post?page=%d&tags=' % i
    url='https://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=index&fr=&hs=0&sf=1&fmq=&pv=&ic=0&nc=1&z=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&word=美女图片&oq=美女图片&rsp=-1'
    pdb.set_trace()
    html = requests.get(url).text
    soup = BeautifulSoup(html, 'html.parser')
    for img in soup.find_all('img', class_="preview"):
        target_url = 'http:' + img['src']
        filename = os.path.join('imgs', target_url.split('/')[-1])
        download(target_url, filename)
    print('%d / %d' % (i, end))