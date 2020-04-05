import subprocess
import threading


def demo(iter_list, if_child=True):
    if not if_child:
        sub = subprocess.Popen(iter_list, shell=True, stdin=subprocess.PIPE,
                               stdout=subprocess.PIPE, stderr=subprocess.PIPE, universal_newlines=True)
        stdout, stderr = sub.communicate()
        if sub.returncode == 0:
            print("正常输出为：", stdout)
            print("code 为：", sub.returncode)
        else:
            print("stderr is :", stderr)
    else:
        p1 = subprocess.Popen(iter_list[0], shell=False,
                              stdout=subprocess.PIPE, universal_newlines=True, stderr=subprocess.PIPE)

        p2 = subprocess.Popen(iter_list[1], shell=False, stdin=p1.stdout,
                              stdout=subprocess.PIPE, universal_newlines=True)
        stdout, stderr = p2.communicate()
        if p2.returncode == 0:
            print("正常输出为：", stdout)
            print("code 为：", p2.returncode)
        else:
            print("stderr is :", stderr)


if __name__ == '__main__':
    arg_list = [[["netstat", "-ano"], ["findstr", "8080"]] for i in range(2)]
    # a=["netstat -ano|findstr 8080" for m in range(4)]
    pool = [threading.Thread(target=demo, args=(i,)) for i in arg_list]
    for th in pool:
        th.start()
    for t in pool:
        t.join()
