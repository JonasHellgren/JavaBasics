# Controlling program flow

switch statements
break placement is important, for ex
    
    switch(today) {
    case SAT:
    case SUN:
    System.out.println("Weekend");
    break;
    default:
    System.out.println("Weekday");
    break;
    }

SAT, SUN => same result

switch on variable, case on final 

nestedLoops, ForWithFor

       int[][] multi = {{100, 105, 110},
                         {200, 205, 210},
                         {300, 305, 310}};

           for(int[] simple : multi)
            for(int value : simple)
                System.out.println(value);

Continue Statement, lines after continue are skipped

        int iVal = 0;
        while (iVal < 10) {
            iVal++;
            if(iVal % 2 == 0)
                continue;
            System.out.println("iVal = " + iVal);  //not executed if iVal is even
        }

break stops the most inner loop

        int iValStart = 1;
        while (iValStart < 4) {
            System.out.println("iValStart = " + iValStart);
            int sum = 0, iVal = iValStart;
            while (iVal < 10) {
                sum += iVal;
                System.out.println("iVal = " + iVal + " sum = " + sum);
                if (sum > 5)
                    break;  //only inner while stopped
                iVal++;
            }
            iValStart++;
        }

