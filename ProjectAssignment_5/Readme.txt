PA_5

1. txt -> txt, txt -> csv working
2. csv -> csv, csv -> txt working
3. normalize working for txt and csv.

//Note: make sure each cell is separated by tabs not by space,
otherwise the program will recognize space as part of a string,
considering it as a single cell.
Ex: [1234 hello] separated by space "1234 hello" -> single String
    [1234    hello] separated by tab "1234" -> Int and "hello" -> String