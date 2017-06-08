if(ch == str[i][j])
{
    str_contain += ch;
//    System.out.println("String contain-->"+str_contain);
    /*
        Checking from left to right (column wise same row)
    */
//    System.out.println("K:"+(j+1)+" "+"Size:"+size);
    for(int k = j+1;(k<size && flag1==false);k++)
    {
        System.out.println("Loop executed"+"--StringContain:"+str_contain);
        temp_str_postn=temp_str_postn+1;
        char ch1 = sub_str.charAt(temp_str_postn);
        System.out.println("Ch1:"+ch1+"--->"+str[i][k]);
        if(ch1 == str[i][k])
        {

            str_contain += ch1;

            if(str_contain.equals( sub_str ))
            {
                System.out.println("substring present"+sub_str);
                start1 = i;
                end1 = k;
                flag1 = true;
            }

        }
        else
        {
          temp_str_postn = 0;
          str_contain ="";
          flag1 = true;
        }
    }
}
temp_str_postn = 0;
