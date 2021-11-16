import xml.etree.ElementTree as ET
import pandas as pd

xml_data = open('properties.xml', 'r').read() # Read file
root = ET.XML(xml_data) # Parse XML

# print(xml_data) # Uncomment this line to see the XML get printed

data = [] # Create a list for data
cols = [] # Create a list for the columns

# Iterate through the data and write them into the data/cols lists
for i, child in enumerate(root):
    data.append([subchild.text for subchild in child])
    cols.append(child.tag)

df = pd.DataFrame(data).T # Write in DataFrame and transpose it
df.columns = cols # Update column names
print(df)