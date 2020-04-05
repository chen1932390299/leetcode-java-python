__author__ = 'Chenquan'
from collections.abc import Generator

# def test():
#      for i in range(4):
#           yield  i
#
# gen=test()
# g= (i for i in range(6))
# for i in g:
#      print(i)

#
# module = __import__("test_module.test")
# print("__import__", module)  # todo import module
# module.test.test1()
#
# import importlib
#
# test = importlib.import_module("test_module.test")  # todo import test.py
# print("importlib>>>", test)
# test.test1()

import unittest


class Test(unittest.TestCase):
    """基于反射,设置，修改，删除类的attr属性解决接口之间依赖关系"""

    @classmethod
    def setUpClass(cls) -> None:
        cls.response_set = Test()
        setattr(cls.response_set, "token","123456")
        pass

    @classmethod
    def tearDownClass(cls) -> None:
        pass

    def test_case1(self):
        res = {"a": 1}
        new_token=getattr(self.response_set,"token")
        print("this is new token",new_token)
        setattr(self.response_set, "response_test1", res)

    def test_case2(self):
        print("response_set __dict__is: \n ", self.response_set.__dict__)
        a = getattr(self.response_set, "response_test1")
        print("test_case2 i get response from test_case1:", a)


if __name__ == '__main__':
    unittest.main(verbosity=2)
