class PriceMeta(type):
    def __new__(cls,class_name,class_base,class_dict):
        class_dict["price"]=lambda self:self.price*self.discount
        return type.__new__(cls,class_name,class_base,class_dict)


class Book(metaclass=PriceMeta):
    # __slots__ = ('name', 'price', 'discount')
    def __init__(self,name,price):
        # super().__init__()
        self.discount=0.8
        self.price=price
        self.name=name

if __name__ == '__main__':
    b = Book('Python基础教程', 89)
    print(b.discount)
    print(b.price)
