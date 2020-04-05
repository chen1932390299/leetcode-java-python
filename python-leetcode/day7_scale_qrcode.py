from MyQR import myqr
from PIL import Image
# todo pip install myqr

# def scale_img(basic_jpg="birth.jpg",url_question='http://x04bxpr7qkzpytu0.mikecrm.com/mPSqWwu',qrcode_name='qrcode.jpg'):
#     myqr.run(
#         words=url_question,
#         save_name=qrcode_name,
#         colorized=True
#     )
#     img = Image.open(qrcode_name)
#     width = img.size[0]  # 获取宽度
#     height = img.size[1]  # 获取高度
#     img2 = img.resize((int(width * 0.3), int(height * 0.3)), Image.ANTIALIAS)
#     print(img2.size[0], img2.size[1])
#     img2.save(qrcode_name)
#     #
#     im = Image.open(basic_jpg)
#     mark = Image.open(qrcode_name)
#     layer = Image.new('RGBA', im.size, (0, 0, 0, 0))
#     layer.paste(mark, (im.size[0] - 120, im.size[1] - 120))
#     out = Image.composite(layer, im, layer)
#     out.save("result.jpg")
def scale_img(basic_jpg="ninegirl.jpg",url_question="you are stupid,haaahaaa!!",qrcode_name='qrcode.jpg'):
    myqr.run(
        words=url_question,
        save_name=qrcode_name,
        colorized=True
    )
    img = Image.open(qrcode_name)
    width = img.size[0]  # 获取宽度
    height = img.size[1]  # 获取高度
    img2 = img.resize((int(width * 0.25), int(height * 0.25)), Image.ANTIALIAS)
    print(img2.size[0], img2.size[1])
    img2.save(qrcode_name)
    #
    im = Image.open(basic_jpg)
    mark = Image.open(qrcode_name)
    layer = Image.new('RGBA', im.size, (0, 0, 0, 0))
    layer.paste(mark, (im.size[0] - 95, im.size[1] - 95))
    out = Image.composite(layer, im, layer)
    out.save("result2.jpg")


if __name__ == '__main__':
    scale_img()

