import urllib.request  
from bs4 import BeautifulSoup  
import re  
import mysql.connector

def getMovieInfo():  
    url="https://movie.douban.com"  
    data=urllib.request.urlopen(url).read()  
    page_data=data.decode('UTF-8')  
    '''''print(page_data)'''  
    soup=BeautifulSoup(page_data,"html.parser")

    #连接mysql
    conn = mysql.connector.connect(host='rm-bp1hdphxcbppg623u.mysql.rds.aliyuncs.com',user='rxp92zte48',password='Zplll123',database='rxp92zte48')
    cursor = conn.cursor()
    cursor.execute('delete from doubanmovie where 1=1')
    

    for link in soup.findAll('li',attrs={"data-actors": True}):
        moviename=link['data-title']
        actors = link['data-actors']
        region=link['data-region']
        release=link['data-release']
        duration = link['data-duration']
        director = link['data-director']
        rate = link['data-rate']
        imgsrc =link.img['src']
        movienamecn=link.img['alt']
        
        cursor.execute("INSERT INTO doubanmovie VALUES ('', %s, %s, %s, %s, %s, %s, %s, %s,now(),%s)",[moviename,actors,region,release,duration,director,rate,imgsrc,movienamecn])

        conn.commit()
        
        print('mysql',cursor.rowcount)
        print(link['data-title'])
        print('演员：',link['data-actors'])
        print(link.img['src'])
    cursor.close()
    conn.close()
          
      
#函数调用  
getMovieInfo()  
