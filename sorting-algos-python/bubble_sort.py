from sorting_utils import read_input, format_and_print_output

def bubble_sort(my_list):
    for i in range(len(my_list)-1, 0, -1):
        for j in range(i):
            if my_list[j] > my_list[j+1]:
                temp = my_list[j]
                my_list[j] = my_list[j+1]
                my_list[j+1] = temp
    return my_list




input_list = read_input()
sorted_list = bubble_sort(input_list)
format_and_print_output(sorted_list)



#See sorting_utils.py 
# #Read input from standard input
# input_string = sys.stdin.readline().strip()

# #Convert the input string into a list of integers
# input_list = [int(x) for x in input_string.split(',')]


# #Sort the list
# sorted_list = bubble_sort(input_list)

# #Convert the sorted list to a comma-separated string
# sorted_string = ",".join(str(x) for x in sorted_list)


# print(sorted_string)