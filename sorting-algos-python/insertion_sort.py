from sorting_utils import read_input, format_and_print_output
def insertion_sort(my_list):
    for i in range(1, len(my_list)):
        temp = my_list[i]
        j = i-1
        while temp < my_list[j] and j > -1:
            my_list[j+1] = my_list[j]
            my_list[j] = temp
            j -= 1
    return my_list


input_list = read_input()
sorted_list = insertion_sort(input_list)
format_and_print_output(sorted_list)