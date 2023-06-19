def merge_sort(my_list):
    if len(my_list) == 1:
        return my_list

    mid_index = len(my_list) //2
    left = merge_sort(my_list[:mid_index])
    right = merge_sort(my_list[mid_index:])

    combined=[]
    i = 0
    j = 0

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            combined.append(left[i])
            i +=1
        else: 
            combined.append(right[j])
            j +=1
    while i < len(left):
        combined.append(left[i])
        i += 1

    while j < len(right):
        combined.append(right[j])
        j +=1
        
    return combined

print(merge_sort([1,3,8,4,7,2]))