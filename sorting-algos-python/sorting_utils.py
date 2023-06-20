import sys
def read_input():
    input_string = sys.stdin.readline().strip()
    return [int(x) for x in input_string.split(',')]


def format_and_print_output(sorted_list):
    sorted_string = ",".join(str(x) for x in sorted_list)
    print(sorted_string)