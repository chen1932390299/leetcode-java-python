import datetime
import time


def week_get():
    """
    days_label = datetime.timedelta(days=now.isoweekday())
    isoweekday return 1-7，1 represent monday 7 represent friday,
    it means current time it's the day of the week .
    date_from = datetime.datetime(day.year, day.month, day.day, 0, 0, 0)
    date_to = datetime.datetime(day.year, day.month, day.day, 23, 59, 59)
    """
    now = datetime.datetime.now()
    monday_cur = datetime.datetime.now() - datetime.timedelta(now.isoweekday() - 1)
    deltas = datetime.timedelta(days=7)
    last_monday = monday_cur - deltas
    last_friday = last_monday + datetime.timedelta(days=4)
    last_friday_date = last_friday.date()
    last_monday_date = last_monday.date()
    return str(last_monday_date), str(last_friday_date)

curtime = time.time()
print(time.strftime("%Y-%m-%d %H:%M:%S",time.localtime(curtime)))
today=datetime.datetime.today()
print(today)
print(today.strftime("%Y/%m/%d"))
add_oneday=today+datetime.timedelta(-1)
print(add_oneday.strftime("%Y/%m/%d"))
rep_day=add_oneday.replace(year=today.year+1,month=today.month+1,day=today.day-1)
print(rep_day)