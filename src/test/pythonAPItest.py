import requests


url = "https://datausa.io/api/data?drilldowns=Nation&measures=Population"
response = requests.get(url)

if response.status_code == 200:
    data = response.json()


    source = url
    years = len(data["data"])
    start_year = data["data"][0]["Year"]
    end_year = data["data"][-1]["Year"]

    peak_growth = max(data["data"], key=lambda x: x["Population"])["Population"]
    peak_growth_year = max(data["data"], key=lambda x: x["Population"])["Year"]
    lowest_growth = min(data["data"], key=lambda x: x["Population"])["Population"]
    lowest_growth_year = min(data["data"], key=lambda x: x["Population"])["Year"]

    peak_growth_per = (peak_growth - lowest_growth) / lowest_growth * 100
    lowest_growth_per = (peak_growth - lowest_growth) / peak_growth * 100

    output = f"According to {source}, in {years} years from {start_year} to {end_year}, " \
             f"peak population growth was {peak_growth_per}% in {peak_growth_year} " \
             f"and the lowest population increase was {lowest_growth_per}% in {lowest_growth_year}."

    print(output)
else:
    print("Failed to retrieve data. Please check the API endpoint or try again later.")


#Result - in 8 years from 2020 to 2013, peak population growth was 4.825344530793709% in 2020 and the lowest population increase was 4.603223154087707% in 2013.