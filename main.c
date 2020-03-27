#include <stdio.h>
#include <mysql.h>

int* getLimit(int* a,int count);
int* draw(int* stati,int count);
int main()
{
    MYSQL mysql;        //mysql数据库连接
    mysql_init(&mysql); //初始化数据库连接

    MYSQL_RES *res;     //指向查询结果的指针
    MYSQL_ROW row;      //按行返回的select结果，即一行记录
    MYSQL_FIELD *field; //指向字段结构体的指针

    int rowCount;       //select结果返回的行数
    int colCount;       //返回的列数；
    int i,j;
    int choose1,choose2;
    int year,mon,day;
    char str1[20],yearc[10],monc[10],dayc[10];
    char select_query[100];
    int stat[3];
    printf("-------------------------防疫信息查询系统-------------------------\n\n");
    if(mysql_real_connect(&mysql, "localhost", "root",
	                     "123456", "experiment2", 3306, NULL, 0))
    {
        mysql_query(&mysql, "set names gbk");
        printf("1.查询某人某天的疫情状况\n2.统计信息\n请选择：");
        while(scanf("%d", &choose1))
        {
            switch(choose1)
            {
                case 1:
                    printf("1.根据ID查找 \n2.根据姓名查找\n请选择：");
                    while(scanf("%d", &choose2))
                    {
                        switch(choose2)
                        {
                            case 1:
                                printf("请输入ID:\n");
                                memset(select_query, 0 ,sizeof(select_query));

                                scanf("%s", str1);
                                printf("请输入date：\n");
                                scanf("%d %d %d",&year,&mon,&day);
                                printf("\n");
                                snprintf(monc,sizeof(monc),"%d",mon);
                                snprintf(dayc,sizeof(dayc),"%d",day);

                                strcat(select_query,
								        "select * from basic,data where basic.ID = data.ID and basic.ID = '");
                                strcat(select_query,str1);
                                strcat(select_query,"' and data.date = '2020-");
                                strcat(select_query,monc);
                                strcat(select_query,"-");
                                strcat(select_query,dayc);
                                strcat(select_query,"'");
                                //printf("%s\n", select_query);

                                if(mysql_query(&mysql, select_query)==0)
                                {
                                    res = mysql_store_result(&mysql);
                                    rowCount = mysql_num_rows(res);
                                    colCount = mysql_num_fields(res);
                                    
									//显示列名
                                    field = mysql_fetch_field(res);
                                    for (i = 0; i<6; i++)
                                        printf("%15s", field[i].name);
                                    for(i = 7; i<10; i++)
                                        printf("%15s", field[i].name);
                                    printf("\n");

                                    //按行显示数据
                                    row = mysql_fetch_row(res);
                                    for(j = 0; j < 6; j++)
                                    {
                                        printf("%15s", row[j]);
                                    }
                                    for(j = 7; j < colCount; j++)
                                        printf("%15s", row[j]);
                                    printf("\n");
                                }
                                else
                                    printf("select fail");
                                break;

                            case 2:
                                printf("请输入姓名:\n");
                                memset(select_query, 0 ,sizeof(select_query));

                                scanf("%s", str1);
                                printf("请输入date：\n");
                                scanf("%d %d %d",&year,&mon,&day);
                                snprintf(monc,sizeof(monc),"%d",mon);
                                snprintf(dayc,sizeof(dayc),"%d",day);

                                strcat(select_query,
								    "select * from basic,data where basic.ID = data.ID and basic.name = '");
                                strcat(select_query,str1);
                                strcat(select_query,"' and data.date = '2020-");
                                strcat(select_query,monc);
                                strcat(select_query,"-");
                                strcat(select_query,dayc);
                                strcat(select_query,"'");
                                //printf("%s\n", select_query);

                                if(mysql_query(&mysql, select_query)==0)
                                {
                                    res = mysql_store_result(&mysql);
                                    rowCount = mysql_num_rows(res);
                                    colCount = mysql_num_fields(res);
                                    field = mysql_fetch_field(res);
                                    for (i = 0; i<6; i++)
                                        printf("%15s", field[i].name);
                                    for(i = 7; i<10; i++)
                                        printf("%15s", field[i].name);
                                    printf("\n");

                                    row = mysql_fetch_row(res);
                                    for(j = 0; j < 6; j++)
                                    {
                                        printf("%15s", row[j]);
                                    }
                                    for(j = 7; j < colCount; j++)
                                        printf("%15s", row[j]);
                                    printf("\n");
                                }
                                else
                                    printf("select fail");
                                break;
                        	default:
                                printf("输入有误，请重新选择：");
                        }
                    }
                    break;

                case 2:
                    memset(select_query, 0 ,sizeof(select_query));
                    printf("请输入需要统计的时间：\n");

                    scanf("%d %d %d",&year,&mon,&day);
                    snprintf(monc,sizeof(monc),"%d",mon);
                    snprintf(dayc,sizeof(dayc),"%d",day);

                    strcat(select_query,
						"select * from data where 是否确诊 = '是' and date = '2020-");
                    strcat(select_query,monc);
                    strcat(select_query,"-");
                    strcat(select_query,dayc);
                    strcat(select_query,"'");
                    //printf("%s",select_query);

                    if(mysql_query(&mysql,select_query)==0)
                    {
                        res = mysql_store_result(&mysql);
                        stat[0] = mysql_num_rows(res);
                        printf("确诊病例:%d\n", stat[0]);
                    }
                    else
                        printf("stat[0] of selection fail");

                    memset(select_query, 0 ,sizeof(select_query));
                    strcat(select_query,
					    "select * from data where 是否疑似 = '是' and date = '2020-");
                    strcat(select_query,monc);
                    strcat(select_query,"-");
                    strcat(select_query,dayc);
                    strcat(select_query,"'");
                    // printf("%s",select_query);

                    if(mysql_query(&mysql,select_query)==0)
                    {
                        res = mysql_store_result(&mysql);
                        stat[1] = mysql_num_rows(res);
                        printf("疑似病例:%d\n", stat[1]);
                    }
                    else
                        printf("stat[1] of selection fail");

                    memset(select_query, 0 ,sizeof(select_query));
                    strcat(select_query,
					    "select * from data where 是否接触 = '是' and date = '2020-");
                    strcat(select_query,monc);
                    strcat(select_query,"-");
                    strcat(select_query,dayc);
                    strcat(select_query,"'");
                    // printf("%s",select_query);

                    if(mysql_query(&mysql,select_query)==0)
                    {
                        res = mysql_store_result(&mysql);
                        stat[2] = mysql_num_rows(res);
                        printf("接触病例:%d\n", stat[2]);
                    }
                    else
                        printf("stat[2] of selection fail");

                    //绘图
                    int count = sizeof(stat)/sizeof(stat[0]);
                    draw(stat,count);
                    break;
                    
            	default:
                	printf("输入有误，请重新选择: ");
                break;
            }
        }
        mysql_close(&mysql);
    }
    else
        printf("fail!");

}
//求出统计信息中的最小值
int* getLimit(int* a,int count)
{
    static int limit[2]={0};
    for(int i=0;i<count;i++)
    {
    	limit[1] = limit[1]>a[i] ? limit[1] : a[i];
        limit[0] = limit[0]<a[i] ? limit[0] : a[i];
    }
    return limit;
}

//绘图函数
int* draw(int* stati,int count)
{
    int * pLimit = getLimit(stati,count);
    int min = pLimit[0]-1;
    int max = pLimit[1];
    printf("\n");
    puts("^");
    printf("|\n");

    for(int i=max+1;i>-100;i=i-100)
    {
        if(i<=0){
            printf("+");
            for(int j=0;j<15*count;j++)
                printf("-");
            puts(">");
        }
        else
        {
            if(i>0){
                printf("|");
                for(int j=0;j<count;j++)
                {
                    if(stati[j]>=i)
                        printf("     ####     ");
                    else if(stati[j]+99 >= i-1)
                        printf("     %d      ",stati[j]);
                    else
                        printf("              ");
                }
                printf(" \n");
            }
        }
    }
    printf("\n");
    printf("    确诊病例      疑似病例      接触病例");
}
