from io import StringIO
from  io import BytesIO
# buffer= StringIO()
# buffer.write("i love python,'Hello!\nHi!\nGoodbye!'")
# buffer.write("seeyou")
# print(buffer.getvalue())
# test stringio
stream = StringIO("i love python,\nHi!\nGoodbye!\nsee you")
print(stream.readlines())
stream.close()
# while True:
#     line=stream.readline()
#     if line =="see you":
#         break
#     print(line)

# todo test bytesio
byte_text=bytes("i love bytes unicode\nsee you",encoding="utf-8")
fp=BytesIO(byte_text)

line =fp.readlines()
print(line)
fp.close()

