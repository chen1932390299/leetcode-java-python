import numpy as np
import pandas as pd
if __name__ == '__main__':
    row_num = 100000
    col_num_a = 1000
    col_num_b = 1000
    aa = np.random.normal( 5, 100, (row_num, col_num_a + col_num_b))
    aa = np.around(aa, decimals=2, out=None)
    aa = pd.DataFrame(aa)
    a = aa.iloc[:, :col_num_a]
    b = aa.iloc[:, col_num_a:]
    index_name_a = ['x'+str(i) for i in range(col_num_a)]
    index_name_b = ['x' + str(i) for i in range(col_num_b)]
    a.columns = index_name_a
    b.columns = index_name_b
    b['y'] = np.random.choice(2, row_num)
    a['id'] = range(row_num)
    b['id'] = range(row_num)
    cc = a.reindex(columns=['id']+index_name_a)
    dd = b.reindex(columns=['id', 'y']+index_name_b)
    #cc.iloc[2:5, 6:8] = np.nan
    #dd.iloc[2:5, 6:8] = np.nan
    #cc.to_csv('F:\\FDN\\在线预测\\test_null_predict_a.csv',index=None)
    #dd.to_csv('F:\\FDN\\在线预测\\test_null_predict_b.csv',index=None)
    # cc.to_csv('/data/projects/fate/python/examples/data/hetero_10w_1000_a.csv', index=None)
    # dd.to_csv('/data/projects/fate/python/examples/data/hetero_10w_1000_b.csv', index=None)
    cc.to_csv('hetero_10w_1000_a.csv', index=None)
    dd.to_csv('hetero_10w_1000_b.csv', index=None)