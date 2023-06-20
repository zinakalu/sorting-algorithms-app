from sorting_utils import read_input, format_and_print_output

def selection_sort(my_list):
    for i in range(len(my_list)-1):
        min_index = i
        for j in range(i+1, len(my_list)):
            if my_list[j] < my_list[min_index]:
                min_index=j
        if i != min_index:
            temp = my_list[i]
            my_list[i] = my_list[min_index]
            my_list[min_index] = temp

    return my_list

# print(selection_sort([3,12,7,23,2,20,6]))

input_list = read_input()
sorted_list = selection_sort(input_list)
format_and_print_output(sorted_list)