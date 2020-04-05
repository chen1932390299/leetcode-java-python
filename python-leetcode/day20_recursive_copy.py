import os
import shutil
# todo python 递归算法


def copy(src,dest):
    files=os.listdir(src)
    os.mkdir(dest)
    for file in files:
        src_file_path= os.path.join(src,file)
        dest_file_path=os.path.join(dest,file)
        if os.path.isfile(src_file_path):
            with open(src_file_path,"rb")as rs:
                reader_stream=rs.read()
            with open(dest_file_path,"wb")as ws:
                ws.write(reader_stream)
        else:
            # is dir
            copy(src_file_path,dest_file_path)

if __name__ == '__main__':
    a=os.path.join(os.getcwd(),"p1")
    b=os.path.join(os.getcwd(),"p2")
    # copy(a,b)
    #shutil.copyfile(r"D:\workspace\pyrestful\leetcode\birth.jpg",r"D:\workspace\pyrestful\leetcode\birthbak.jpg")
    # shutil.copytree(from,to)
    # todo copy file or dir ,but dir must have w,r,x auth
    # shutil.copy(src,dest)