class BlackMedium:
    def __init__(self, name, address):
        self.name = name
        self.address = address

    def sell_house(self):
        return


if __name__ == '__main__':
    p = BlackMedium("name", "addr")
    print(hasattr(p, "name"))
    setattr(p, "name", "zhangsan")
    print(getattr(p, "name", "None111"))  # todo if exist return else default msg
    # delattr(p,"name")
    print(getattr(p, "name"))  # del attr
    # delattr(p,"key")
    setattr(p, "func", lambda self: self.name + "add")
    print(p.__dict__)
    print(p.func(p))
