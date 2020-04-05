
class Person:

    def __init__(self,name,age):
        self.__name=name
        self.__age=age

    def set_atrr(self,out_name,out_age):
        if out_age >129:
            raise  ValueError("age must less 129")
        self.__age=out_age
        self.__name=out_name

    def get_attr(self):
        return self.__age,self.__name
    #先有get 再有set
    @property
    def age(self):
        return self.__age
    @age.setter
    def age(self,out_age):
        if out_age >129:
            raise  ValueError("age must less 129")
        self.__age=out_age

    def  __str__(self):
        return f"当前学生是{self.__name},age is {self.__age}"


if __name__ == '__main__':
    p=Person("雨果",100)  # 当当前学生是雨果,age is 100
    p.__name="zhang" # 当前学生是雨果,age is 100,还是雨果，修改失败，因为是私有属性
    p.set_atrr("列夫托尔斯泰",99)
    print(p)  #当前学生是列夫托尔斯泰,age is 99
    a,b=p.get_attr()
    print(a,b)  #99 列夫托尔斯泰
    print("dir()>>>>>",dir(p))  # 不会看到： __age ,__name attribute ,但是'_Person__age', '_Person__name'可以获取到
    print(p._Person__age, p._Person__name)  # 99 列夫托尔斯泰
    print("==============")
    print("查询age",p.age)
    p.age=0
    print("修改后age",p.age)
    print(dir(p)) # [.....,'age',]多了一个age attribute

