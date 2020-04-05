# todo 面向对象,类方法不依赖于对象,无法访问对象以及对象属性，创建在对象之前.静态方法无需传递对象self和cls
#  无法访问对象self和对象self的属性,只能访问类方法以及类属性，在创建对象之前可以使用，不依赖于对象
#  对象可以访问对象的属性，也可以访问类方法和属性
# 普通方法，依赖于对象，需要对象来调用，没有装饰器。
class Dog:
    age=1
    def __init__(self,name):
        self.name=name

    def set_name(self):
        """self表示对象本身---->  <__main__.Dog object at 0x033C6B90> """
        self.name="xiaogou"
        self.age =99
        print(self,self.age)  # self.age也可以 先在对象方法来找，找不到再去class找age
        print(Dog.age) ## 正确的调用示范

    @classmethod
    def get_class(cls):
        print(cls) # <class '__main__.Dog'>
        #print(self.set_name)  # 反面教材，类方法无法修改对象的属性，也无法调用对象方法self.name
        #print(cls.name) #err usage: AttributeError: type object 'Dog' has no attribute 'name'
    @staticmethod
    def test_static():
        #print(self.name)  # 错误用法
        print(Dog.age)

if __name__ == '__main__':
    dog=Dog("dahuang")
    dog.get_class()
    dog.set_name()
    print(dog.name,dog.age)
    dog.test_static()