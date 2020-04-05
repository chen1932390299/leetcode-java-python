import numpy as np
import pandas as pd


def hetero_gen(rows: int, col_guest: int, col_host: int, part="all"):
    id_list = range(rows)
    y_list = np.random.choice(2, rows)
    # cols = col_guest + col_host
    cols=col_host
    a = np.random.normal(0, 1, (rows, cols))
    data = np.around(a=a, decimals=6, out=None)
    host_df = pd.DataFrame(data)
    guest_df = host_df.iloc[:, :col_guest]  # <class 'pandas.core.frame.DataFrame'>
    guest_columns = [f"x{i}" for i in range(col_guest)]
    host_columns = [f"x{j}" for j in range(cols)]
    guest_df.columns = guest_columns
    host_df.columns = host_columns
    # to resolve SettingWithCopyWarning
    host_df.insert(0, "id", id_list)
    guest_df.insert(0, "id", id_list)
    guest_df.insert(1, "y", y_list)
    guest = guest_df.reindex(columns=["id", "y"] + guest_columns)
    host = host_df.reindex(columns=["id"] + host_columns)
    if part == "all":
        guest.to_csv(f"./hetero_10w_chen.csv", index=False)
        print(f"guest>>>>> generate hetero_10w_chen {guest.shape}")

        host.to_csv(f"./chen_breast_a.csv", index=False)
        print(f" host <<<< generate 10w  chen_breast_a.csv shape: {host.shape}")


def homo_gen(rows: int, col_guest: int, col_host: int, part="all"):
    g = np.random.normal(0, 1, (rows, col_guest))
    h = np.random.normal(0, 0.7, (rows, col_host))
    # random not put back
    id_list_guest = np.random.choice(rows + 100, rows, replace=False)
    id_list_host = np.random.choice(range(rows + 200, 2 * rows + 300), rows, replace=False)
    y_list = np.random.choice(2, rows)
    data_guest = np.around(a=g, decimals=6, out=None)
    data_host = np.around(a=h, decimals=6, out=None)
    host_df = pd.DataFrame(data_host)
    guest_df = pd.DataFrame(data_guest)

    guest_columns = [f"x{i}" for i in range(col_guest)]
    host_columns = [f"x{j}" for j in range(col_host)]
    guest_df.columns = guest_columns
    host_df.columns = host_columns

    host_df.insert(0, "id", id_list_host)
    host_df.insert(1, "y", y_list)
    guest_df.insert(0, "id", id_list_guest)
    guest_df.insert(1, "y", y_list)

    guest = guest_df.reindex(columns=["id", "y"] + guest_columns)
    host = host_df.reindex(columns=["id", "y"] + host_columns)
    if part == "all":
        guest.to_csv(f"./chen_homo_guest.csv", index=False)
        host.to_csv(f"./chen_homo_host.csv", index=False)
        print(f" generate 10w chen_homo_guest.csv shape: {guest.shape}")
        print(f" generate 10w chen_homo_host.csv shape: {host.shape}")


if __name__ == '__main__':
    hetero_gen(1000,10,20)
    # homo_gen(100000,20,20)

